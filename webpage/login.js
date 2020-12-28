

window.localStorage.clear();
sessionStorage.clear()
let user;

function change(){
   //user = JSON.parse (localStorage.getItem("json"))
   // document.getElementById("name").innerHTML= one.email;
}

function goTO(){
    window.location.href = "./home.html";
    //change();
}







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

         res = await fetch("http://localhost:8080/project1/login", {
            
            
            method: "POST",

            
            body: JSON.stringify(credentials),
           headers:{
                "Content-Type" : "application/json"
            }
        })

          user = await res.json()
          
          sessionStorage.setItem("json", JSON.stringify(user));
          
            
         
          goTO()
         console.log(user);
         return user.data
      
        
    }
    
    
       

     catch(e){
        console.log(e)
    }


   

}


document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit)

async function goTO() {
    window.location.href = "./home.html";
    
}



 
 