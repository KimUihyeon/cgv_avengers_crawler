
//const {Builder, By, Key, until} = require('selenium-webdriver');

var moment = require('moment');
var webdriver = require('./node_modules/selenium-webdriver'),
    By = webdriver.By,
    until = webdriver.until;

var driver =  new webdriver.Builder()
    .forBrowser('chrome')
    .build();

const url = 'http://www.ssg.com/item/itemView.ssg?itemId=1000043583824&siteNo=6004&salestrNo=6005&tarea=history_6005'; // 닌텐도 모동숲


async function search (){

    let date = moment().format('YYYY-MM-DD | hh:mm:ss');
    
    var target = By.id('oriCart');
    await driver.get(url);
    driver.manage().deleteAllCookies();
    await driver.wait(until.elementLocated(target), 3 * 1000);
    await driver.findElement(target).then(v=>{
        v.getText().then((_v)=>{
            let msg = getMessage(date,url,_v);
            console.log(msg);
        }).then(()=>{
            setTimeout(()=>{
                //driver.close();
            },3000);
        }

        );
    });    
}


function getMessage(date, url, context){
    return `${date}\t\t | ${url}\t\t | ${context}`;
}


search();


module.exports.nintendo= search;