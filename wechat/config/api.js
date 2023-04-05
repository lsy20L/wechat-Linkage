var WxApiRoot = 'https://localhost:8080/wx/';
// var WxApiRoot='https://43.143.184.134:8080/wx/';
module.exports={
  IndexUrl: WxApiRoot + 'home/index',
  VideoPost:WxApiRoot+'video/add',
  VideoDetail: WxApiRoot + 'video/detail',
  VideoSearch: WxApiRoot + 'video/search',
  TextPost: WxApiRoot+'text/add',
  TextIndex:WxApiRoot + 'text/index',
  TextTopic:WxApiRoot + 'text/topic',
  TextList:WxApiRoot +'text/list',
  TextDetail: WxApiRoot + 'text/detail',
  TopicName:WxApiRoot + 'topic/name',
  UploadStorage:WxApiRoot+'upload/storage',
  CommentPost:WxApiRoot+'comment/add',
  LoginByWeixin: WxApiRoot + 'user/login_by_weixin',
}