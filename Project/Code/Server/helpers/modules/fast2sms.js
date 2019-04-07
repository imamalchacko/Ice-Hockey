var unirest = require("unirest");

var req = unirest("GET", "https://www.fast2sms.com/dev/bulk");

var sendOTP=function(mobile,otp){
    msg = "Your OTP for Ice Hockey is: "+otp;
    req.query({
        "authorization": "puGtaMq56beNiXSJVlmLCPnHrAvyB1x9z0Eh2cwgWo7IdjR83KagF3HPULiZyneTKO8YE1MWuhtG7vrQ",
        "sender_id": "FSTSMS",
        "message": msg,
        "language": "english",
        "route": "p",
        "numbers": mobile
    });

    req.headers({
        "cache-control": "no-cache"
    });

    req.end(function (res) {
        if (res.error) throw new Error(res.error);
        console.log(res.body);
    });
}

module.exports=sendOTP;