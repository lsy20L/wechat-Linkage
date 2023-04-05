const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return `${[year, month, day].map(formatNumber).join('/')} ${[hour, minute, second].map(formatNumber).join(':')}`
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : `0${n}`
}

function request(url, data = {}, method = "GET") {
  return new Promise(function(resolve, reject) {
    wx.request({
      url: url,
      data: data,
      method: method,
      header: {
        'Content-Type': 'application/json'
      },
      success: function(res) {
        if (res.statusCode == 200) {
            resolve(res.data);
        } else {
          reject(res.errMsg);
        }
      },
      fail: function(res) {
        reject(res)
      }
    })
  });
}
function redirect(url) {

  //判断页面是否需要登录
  if (false) {
    wx.redirectTo({
      url: ''
    });
    return false;
  } else {
    wx.redirectTo({
      url: url
    });
  }
}
function showErrorToast(msg) {
  wx.showToast({
    title: msg,
    image: '/static/images/icon_error.png'
  })
}
module.exports = {
  formatTime,
  request,
  redirect,
  showErrorToast
}
