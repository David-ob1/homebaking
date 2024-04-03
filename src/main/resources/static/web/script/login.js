 const formRegister = document.getElementById("register")

 let registerEP = "/api/client/new"

 let $name = document.getElementById("name")
 let lastName = document.getElementById("lastName")
 let email = document.getElementById("email")
 let password = document.getElementById("password")


//  console.log()
 const btnRegister = document.getElementById("btn-register")
//  alert("hola")
    btnRegister.addEventListener("click",()=>{

        let newClient = obtenerValores()

        axios.post(registerEP, newClient)
            .then(data =>{
                console.log(data)

                setTimeout(() => {
                    location.href = '../index.html';
                    console.log("Retrasado por 2 segundo.");
                  }, 2000);



            })

            
            .catch(error => console.log(error))


        
    })


 
  function obtenerValores(){
       return {
        name: $name.value,
        lastName: lastName.value,
        email: email.value,
        password: password.value
    };

    }