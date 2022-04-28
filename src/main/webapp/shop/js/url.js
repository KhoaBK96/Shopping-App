let hiddenDatas = document.getElementsByClassName("hiddenData");
let searchForm = document.getElementById("searchForm");

searchForm.addEventListener("submit", (e) => {
  e.preventDefault();
  let url = window.location.origin + window.location.pathname;
  url += "?productSearch=" + document.getElementById("search").value;

  for (let i = 0; i < hiddenDatas.length; i++) {
    url += "&" + hiddenDatas[i].name + "=" + hiddenDatas[i].value;
  }
  window.location = url;
});
