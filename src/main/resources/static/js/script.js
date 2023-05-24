var main = {
  init: function() {
    var _this = this;

    $('#send-btn').on('click', function() {
      _this.send();
    });
    $('#send-data').on('keyup', function(e) {
      if (e.keyCode === 13) {
        e.preventDefault();
        $('#send-btn').click();
      }
    });
  },
  send: function() {
    var data = $('#send-text').val();
    if (!data) {
      alert('내용을 입력해주세요');
      return;
    }
    $.ajax({
      type: 'GET',
      url: '/api/v1/create/' + data,
    }).done(function(){
        alert('전송완료!');
        window.location.href = '/';
        $('#send-data').val('');
        $('#send-data').prop('readonly', false);
    }).fail(function(){
        alert('오류발생! 페이지를 새로고침해주세요');
        window.location.href = '/';
    });
  }
};


main.init();