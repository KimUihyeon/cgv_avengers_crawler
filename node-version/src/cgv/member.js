

/**
 * id : mail ID
 * name : user name
 * isSend : 전송 유무
 * isTest : 테스트 메일 발송유무
 * sendCount : 전송 횟수
 */
let requestMembers =  [
    { id : "email@mail.com", name : 'name', isSend : false , isTest : true, sendCount: 0},
    { id : "email@mail.com", name : 'name', isSend : false , isTest : true, sendCount: 0},
    { id : "email@mail.com", name : 'name', isSend : false , isTest : true, sendCount: 0},
]



let senderUser = {
    user : 'mail@mail.com',
    pass : '*****'
}

let sendTestMail = {
    from : 'mail@mail.com',
    to : 'mail@mail.com'
}

module.exports.requestMembers = requestMembers;
module.exports.senderUser = senderUser;
module.exports.sendTestMail = sendTestMail;