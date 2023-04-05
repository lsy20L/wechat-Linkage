const api = require('../../config/api');
const util = require('../../utils/util');

const app = getApp();
Page({
  data: {
    ads:[],
    videos:[],
    topics:[],
  },
  onShareAppMessage: function() {
    return {
      title: 'Linkage校园互助平台',
      desc: '微信小程序',
      path: '/pages/index/index'
    }
  },
  onPullDownRefresh() {
    wx.showNavigationBarLoading() //在标题栏中显示加载
    this.getIndexData();
    wx.hideNavigationBarLoading() //完成停止加载
    wx.stopPullDownRefresh() //停止下拉刷新
  },
  getIndexData:function(){
    let that = this;
    util.request(api.IndexUrl).then(function(res){
      if(res.errno==0){
        that.setData({
          ads:res.data.adList,
          videos:res.data.videoList,
          topics:res.data.topicList
        });
      }
    });
  },
  onShow:function(){
    this.getIndexData();
  },
})
