var express = require('express');
var bodyParser = require('body-parser')
var mongoose = require('mongoose');
var User = require('./helpers/mongodb/models/user');
var fast2sms = require('./helpers/modules/fast2sms');


var app=express();
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.raw({ inflate: true, limit: '100kb', type: 'text/xml' }));
app.use(bodyParser.json());
var port=process.env.PORT || 3000;

var smsEnabled=true;

var mongoUrl = "mongodb://admin:admin123@ds161024.mlab.com:61024/ice-hockey";
mongoose.connect(mongoUrl, { useNewUrlParser: true });
mongoose.set('useCreateIndex', true);
var db = mongoose.connection;
db.on('error', console.error.bind(console, 'MongoDB connection error:'));
db.once('open', function () {
    console.log("Database connected successfully..");
});

app.get('/', function (req, res) {
    res.send("App working...");
});

app.post('/authStep1', function (req, res) {
    otp = Math.floor(100000 + Math.random() * 900000);
   
    var newUser = new User({
        mobile: req.body.mobile,
        otp: otp
    });

    newUser.save(function (err) {
        if (err) {      
            if(err.code==11000){
                User.updateOne({ mobile: req.body.mobile }, { otp: otp }, function (err, user) {
                    if (err){
                        res.send("0"); 
                    }
                    else{
                        if(smsEnabled){
                            fast2sms(req.body.mobile,otp);
                        }        
                        res.send("1");
                    }
                });
            }
            else{
                res.send("0"); 
            }
        }else{
            if (smsEnabled) {
                fast2sms(req.body.mobile, otp);
            }   
            res.send("1");
        }
        
    });
    
})


app.post('/authStep2', function (req, res) {
    User.findOne({ mobile: req.body.mobile }, function (err, user) {
        if (err) {
            res.send("0");
        }
        else if (user.otp == req.body.otp ){
            res.send("1");
        }
        else{
            res.send("0");
        }
    });   
})



/*
User.find({}, function (err, users) {
    if (err) {
        console.log(err.code);
    }
    console.log(JSON.stringify(users));
});
res.send('OKeyyy');

*/
app.listen(port, () => console.log(`App listening on port `+port+`!`))