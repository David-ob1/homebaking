const logout = document.getElementById("logout")

logout.onclick = () => {
    axios.post("api/logout")
    .then(response => {
        console.log("sing out!")
        // location.href = "/web/login.html"
    })
    .catch(error => console.log(error))
}