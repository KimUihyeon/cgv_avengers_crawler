const moment = require('moment');
const mailService = require('./src/nintendo/mailService');
//const cgv = require('./src/cgv/avengersParser');
const nintendo = require('./src/nintendo/nintendoParser');
const nintendoTest = require('./test') 

let intervalOffset =  1;                    // 단위 (운영모드 | 분)
let isTest = false;                         // 개발자모드 true = 테스트로직 태움

///
/// application Start Logic
///
let appStart = function (){
    let date = moment().format();
    console.log('Service Start time( '+date+' )');

    if(isTest === true){
        mailService.mailSendTest();
    }

    setInterval(()=>{

        nintendoTest.nintendo();
        //nintendo.nintendoParser();
        //cgv.avengersParser();
    }, intervalOffset * 1000 * 180);
}

appStart();