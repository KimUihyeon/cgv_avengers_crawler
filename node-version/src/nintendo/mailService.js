const nodemailer = require('nodemailer');
const member = require('./member')
const transporter = nodemailer.createTransport({
    service:'gmail',
    auth: member.senderUser
});



let sendMail = function(mailOption){
    transporter.sendMail(mailOption, function(err, info) {
        if ( err ) {
            console.error('Send Mail error : ', err);
        }
        else {
            console.log('------------------------------');
            console.log('Message sent : ', info);
            console.log('------------------------------');
        }
    });
}


let mailSendAll = function (){
    member.requestMembers.forEach(element => {
        let mailInfo = element;

        let mailOption = {
            from : 'mail',
            to : 'mail',
            subject : '어벤져스 예매시작함 !!',
            text : 'http://www.cgv.co.kr/movies/detail-view/?midx=81749 || CGV 바로가기 복붙'
        };
        mailOption.to = mailInfo.id;

        if(mailInfo.isSend == false){
            sendMail(mailOption);
            mailInfo.sendCount++;
            console.log('Mail Service ->  '+ mailOption.to);
            console.log('Mail Service ->  '+ mailInfo.name);
            console.log('Mail Service ->  '+ mailInfo.sendCount + '번 전송')
            mailInfo.isSend=true;

        }

    });
}

let mailSendTest = function() {
    mailList.forEach(element => {
        let mailInfo = element;

        let mailOption = {
            ...member.sendTestMail,
            subject : '어벤져스 테스트 메일입니다.',
            text : '어벤져스 테스트 메일입니다.'
        };
        mailOption.to = mailInfo.id;
        if(mailInfo.isTest == false){
            sendMail(mailOption);
            console.log('Mail test Service ->  '+ mailOption.to);
            console.log('Mail test Service ->  '+ mailInfo.name);
            mailInfo.isTest=true;
        }

    });
}


module.exports.mailSendAll = mailSendAll;
module.exports.mailSendTest = mailSendTest;