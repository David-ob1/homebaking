//form js for efect
const  wrapper = document.querySelector(".wrapper")
const  registerLink = document.querySelector(".register-link")
const  loginLink = document.querySelector(".login-link")

registerLink.onclick = ()=>{
    wrapper.classList.add("active")
}

loginLink.onclick = ()=>{
    wrapper.classList.remove("active")
}


//form js for login/register


 const registerEP = "/api/client/new"
 const loginEP = "/api/login"

 //btns
const btnLogin = document.getElementById("login")
const btnRegister = document.getElementById("register")

 //login

 const emailL = document.getElementById("emailLogin")
 const passwordL = document.getElementById("passwordLogin")

 btnLogin.addEventListener("click",()=>{

    let auth = `email=${emailL.value}&password=${passwordL.value}`
    axios.post(loginEP,auth)
        .then(data =>{
            console.log(data)
            
            setTimeout(() => {
                location.href = '../index.html';
                console.log("Retrasado por 1 segundo.");
                }, 1000);

        })
        .catch(error => {
            console.log(loginValues ())
            error   
        }
            
            )

 })
 

 //register 

  let $name = document.getElementById("name")
  let lastName = document.getElementById("lastName")
  let email = document.getElementById("email")
  let password = document.getElementById("password")

  btnRegister.addEventListener("click",() =>{
   
    let newClient = registerValues()

    axios.post(registerEP,newClient)
        .then(data => {
            console.log(data)
            console.log("register")

    let auth = `email=${newClient.email}&password=${newClient.password}`
            axios.post(loginEP,auth)
            console.log("login")
            setTimeout(() => {
            // location.href = '../index.html';
            alert("hola")

            console.log("Retrasado por 2 segundo.");
            }, 3000);


        })
        .catch(error => console.log(error))
  })



  function registerValues(){
       return {
        name: $name.value,
        lastName: lastName.value,
        email: email.value,
        password: password.value
    };

    }