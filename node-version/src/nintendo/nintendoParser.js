let cheerio = require('cheerio');
let moment = require('moment');
let request = require('request');
let mailService = require('./mailService');

const url = 'http://www.ssg.com/item/itemView.ssg?itemId=1000043583824&siteNo=6004&salestrNo=6005&tarea=history_6005'; // 닌텐도 모동숲

let nintendoParser = function (){
    request(url, (error, response, html)=>{
        if (error) {throw error};
        let $ = cheerio.load(html);
        let date = moment().format();

        console.log('닌텐도 모동숲 크롤러 실행중... time( '+date+' )')

        console.log(html);

        $('#oriCart .tx_ko').each(()=>{
            let context = $(this).text();
            console.log(context)
            if(context !== null){
                //mailService.mailSendAll();
                console.log("log : " + $(this).text());
            }
        })
        
    });
}

module.exports.nintendoParser = nintendoParser;
