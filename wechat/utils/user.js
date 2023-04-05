const util = require('../utils/util.js');
const api = require('../config/api.js');

function checkSession(){
  return new Promise(function(resolve,reject){
    wx.checkSession({
      success:function(){
        resolve(true);
      },
      fail:function(){
        reject(false);
      }
    })
  });
}

function login(){
  return new Promise(function(resolve,reject){
    wx.login({
      success:function(res){
        if(res.code){
          resolve(res);
        }else{
          reject(res);
        }
      },
      fail:function(res){
        reject(res);
      }
    });
  });
}
function loginByWeixin(userInfo){
  return new Promise(function(resolve,reject){
    return login().then((res)=>{
      util.request(api.LoginByWeixin,{
        code:res.code,
        userInfo:userInfo
      },'Post').then(res=>{
        if (res.errno === 0) {
          //存储用户信息
          wx.setStorageSync('userInfo', res.data.userInfo);
          wx.setStorageSync('skey', res.data.skey);

          resolve(res);
        } else {
          reject(res);
        }
      }).catch((err) => {
        reject(err);
      });
    }).catch((err) => {
      reject(err);
    })
  });
}

function checkLogin() {
  return new Promise(function(resolve, reject) {
    if (wx.getStorageSync('userInfo') && wx.getStorageSync('skey')) {
      checkSession().then(() => {
        resolve(true);
      }).catch(() => {
        reject(false);
      });
    } else {
      reject(false);
    }
  });
}
module.exports = {
  loginByWeixin,
  checkLogin,
};
