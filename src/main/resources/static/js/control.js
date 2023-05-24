const message = document.getElementById("send-text");
const btn = document.getElementById("send-btn");
function readO() {
  message.value = "ai가 생각중입니다";
  message.readOnly = true;
}
