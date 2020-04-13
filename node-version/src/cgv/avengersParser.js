let cheerio = require('cheerio');
let moment = require('moment');
let request = require('request');
let mailService = require('./mailService');

const url = 'http://www.cgv.co.kr/movies/detail-view/?midx=81749'; // 어벤져스 엔드게임 

///
/// getData by Cgv Url
///  
let avengersParser = function (){
    request(url, (error, response, html)=>{
        if (error) {throw error};
        let $ = cheerio.load(html);
        let date = moment().format();

        console.log('cgv Avengers crawler 실행중... time( '+date+' )')

        $('#select_main .like .link-reservation').each(function(){
            let context = $(this).text();
            if(context !== null){
                mailService.mailSendAll();
                console.log("log : " + $(this).text());
            }
        })
    });
}

module.export.avengersParser = avengersParser;
