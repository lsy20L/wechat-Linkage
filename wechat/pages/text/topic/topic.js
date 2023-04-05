var util = require('../../../utils/util');
var api = require('../../../config/api');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    scrollLeft: 0,
    scrollTop: 0,
    scrollHeight: 0,
    id:0,
    texts:[],
    topics:[]
  },
  onLoad:function(options){
    var that = this;
    if(options.id){
      that.setData({
        id:parseInt(options.id)
      });
    }
    wx.getSystemInfo({
      success: function(res) {
        that.setData({
          scrollHeight: res.windowHeight
        });
      }
    });
    this.getTopicInfo();
  },
  getTopicInfo:function(){
    let that = this;
    util.request(api.TextTopic, {
        id: this.data.id
      })
      .then(function(res) {
        if (res.errno == 0) {
          that.setData({
            topics:res.data.topics
          });
          wx.setNavigationBarTitle({
            title:res.data.topicName
          })
          //nav位置
          let currentIndex = 0;
          let topicsCount = that.data.topics.length;
          for (let i = 0; i < topicsCount; i++) {
            currentIndex += 1;
            if (that.data.topics[i].topicID == that.data.id) {
              break;
            }
          }
          if (currentIndex > topicsCount / 2 && topicsCount > 5) {
            that.setData({
              scrollLeft: currentIndex * 60
            });
          }
          that.getTextList();
        } else {
          //显示错误信息
        }

      });
  },
  getTextList:function(){
    var that = this;
    util.request(api.TextList, {
        id: this.data.id
      })
      .then(function(res) {
        that.setData({
          texts: res.data.texts
        });
      });
  },
  switchCate:function(event){
    if (this.data.id == event.currentTarget.dataset.id) {
      return false;
    }
    var that = this;
    var clientX = event.detail.x;
    var currentTarget = event.currentTarget;
    if (clientX < 60) {
      that.setData({
        scrollLeft: currentTarget.offsetLeft - 60
      });
    } else if (clientX > 330) {
      that.setData({
        scrollLeft: currentTarget.offsetLeft
      });
    }
    this.setData({
      id: currentTarget.dataset.id,
      texts:[]
    });
    this.getTopicInfo();
  }
})