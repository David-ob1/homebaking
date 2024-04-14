//form js for efect
const  wrapper = document.querySelector(".wrapper")
const  registerLink = document.querySelector(".register-link")
const  loginLink = document.querySelector(".login-link")
const loader = document.getElementById("loader")

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

    loader.style.display = "flex"



    let auth = `email=${emailL.value}&password=${passwordL.value}`
    axios.post(loginEP,auth)
        .then(data =>{
            console.log(data)

            alert()
            
            setTimeout(() => {
                loader.style.display = "none"
                location.href = '../index.html';
                console.log("Retrasado por 1 segundo.");
                }, 1000);

        })
        .catch(error => {
            console.log(emailL.value)
            console.log(passwordL.value )

           alert(error)

           loader.style.display = "none"
        }
            
            )

    setTimeout(() => {
         loader.style.display = "none"

        }, 600);



 })
 

 //register 

  let $name = document.getElementById("name")
  let lastName = document.getElementById("lastName")
  let email = document.getElementById("email")
  let password = document.getElementById("password")

  btnRegister.addEventListener("click",() =>{

    loader.style.display = "flex"

   
    let newClient = registerValues()

    axios.post(registerEP,newClient)
        .then(data => {
            console.log(data)
            console.log("register")
    loader.style.display = "none"


    let auth = `email=${newClient.email}&password=${newClient.password}`
            axios.post(loginEP,auth)
            console.log("login")

            // alert("hola")


            setTimeout(() => {
                loader.style.display = "none"
                
                
                // location.href = '../index.html';
            console.log("Retrasado por 2 segundo.");
            }, 1000);


        })
        .catch(error => console.log(error))

        setTimeout(() => {
            loader.style.display = "none"
   
           }, 300);
  })



  function registerValues(){
       return {
        name: $name.value,
        lastName: lastName.value,
        email: email.value,
        password: password.value
    };

    }