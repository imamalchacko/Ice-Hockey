
var unirest = require("unirest");

var req = unirest("POST", "https://www.fast2sms.com/dev/wallet");

req.headers({
    "authorization": "puGtaMq56beNiXSJVlmLCPnHrAvyB1x9z0Eh2cwgWo7IdjR83KagF3HPULiZyneTKO8YE1MWuhtG7vrQ"
});


req.end(function (res) {
    if (res.error) throw new Error(res.error);

    console.log(res.body);
});