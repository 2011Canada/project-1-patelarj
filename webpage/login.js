

let res;

async function loginSubmit(e){
    e.preventDefault();

    let userName = document.getElementById("username-input").value
    let userPassword = document.getElementById("password-input").value


    //enhanced object literals

    const credentials = {
        userName,
        userPassword
    }


    try{

         res = await fetch("http://localhost:8080/Project1/login", {
            method: "POST",
            
            body: JSON.stringify(credentials),
            headers:{
                "Content-Type" : "application/json"
            }
        })

         let user = await res.json()
    
       
       console.log(user);

    } catch(e){
        console.log(e)
    }


    document.getElementById("usename").innerHTML= res.userName;

}

document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit)