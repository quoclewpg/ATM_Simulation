const money = [20, 50, 100];
var amount = 1050;
var bills = new Array();

function withdrawMoney(money, amount){
    var divs = new Array();
    var results = new Array();
    var div;

    while(amount > 0){
        for(var i = 0; i < money.length; i++){
            div = Math.floor(amount / money[i]);
            
            if(div !=0){
                divs.push(div);
            }
        }
        bills.push(money[divs.indexOf(Math.min(...divs))]);
        results.push(Math.min(...divs));
        amount = amount - bills.slice(-1).pop();
        divs.splice(0, divs.length);
    }
    return results;
}

function printMoney(withdraw, bills){
    for(var i = 0; i < bills.length; i++){
        document.getElementById("result").innerHTML += withdraw[i] + " ";
        document.getElementById("bills").innerHTML += bills[i] + " bills ";

        for(var j = i + 1; j < bills.length; j++){
            if(bills[i] === bills[j]){
                i++;
            }
        }
    }
}

var withdraw = withdrawMoney(money, amount);
printMoney(withdraw, bills);