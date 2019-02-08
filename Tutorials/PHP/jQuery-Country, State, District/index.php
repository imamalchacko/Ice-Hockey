<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Page Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <script src="js/jquery.js"></script>
      <script src="js/main.js"></script>
</head>
<body>
    <div id="navBar">
        <button id="country">Add Country</button>
        <button id="state">Add State</button>
        <button id="district">Add District</button>
    </div>
    <div id="mainArea"><br>
        <div id="a1">
            Country Name: <input type="text" id=acname> <button id=addCName> Add</button>
        </div>
        <div id="a2">
        <select id="a2Country">
            <option value=null>Select country</option>
        </select>
            State Name: <input type="text" id=a2sname> <button id=addSName> Add</button>
        </div>
        <div id="a3">
        <select id="a3Country" onchange=getState()>
        </select>
        <select id="a3State">
        </select>
            District Name: <input type="text" id=adname> <button id=addDName> Add</button>
        </div>
    </div>
</body>
</html>