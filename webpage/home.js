
    // get the data form the session storage 
    user = JSON.parse(sessionStorage.getItem("json"))

    if(user === null){

        window.location.href = "./login.html";
     }
     

     document.getElementById("name").innerHTML= "Name :- " + user.firstName +" "+ user.lastName;
     
     
     // hide the form form the user at first 
     document.getElementById("form").style.display = "none";
    
let data
let length;
 async function getReimbursement() {
    try {
       
        let response = await fetch("http://localhost:8080/project1/home" ,

        {
           method: "POST",
            body: JSON.stringify(user),
            headers:{
                "Content-Type" : "application/json"
            }
        
        
        
         } )
        


        data = await response.json()
        sessionStorage.setItem("claims", JSON.stringify(data));
         createTable(data);
         
         
        console.log(data)
       return data;
    }catch(e){
    
        console.log("ops somthoing went wrong")
    }
}
getReimbursement();

let  claim = JSON.parse(sessionStorage.getItem("claims"));

 
    function createTable(data){
        let total =0 ;
        for(let j = 0; j<data.length; j++){
            let creatTr = document.createElement("tr");


            
            let creatTh = document.createElement("th");

            creatTh.scope = "row";
            creatTh.innerHTML= data[j].reimb_ID;
            let tBody = document.getElementById("tbody")
            tBody.appendChild(creatTr);
            creatTr.appendChild(creatTh);
        for(let i = 1; i<=7; i++){
            let creatTd = document.createElement("td");
             creatTd.id = total++;
                creatTr.appendChild(creatTd);
    }
    }
    fillData(data);
    }



function fillData(data){
let total = 0;
for(let j = 0; j<data.length; j++){


   document.getElementById(total).innerHTML= data[j].reimbAmount;
   total++;
   document.getElementById(total).innerHTML=data[j].reimbSubmitted;
   total++;
   document.getElementById(total).innerHTML=data[j].reimbResolved;
   total++
   document.getElementById(total).innerHTML=data[j].reimbDescription;
   total++
    if(data[j].reimbStatusID ===1){
        document.getElementById(total).innerHTML="Panding";
        document.getElementById(total).style.color ="#DDDA47"
    }
    else if(data[j].reimbStatusID ===2){
        document.getElementById(total).innerHTML="Approved";
        document.getElementById(total).style.color ="#59A118"
    }
    else if(data[j].reimbStatusID ===3){
        document.getElementById(total).innerHTML="Denied";
        document.getElementById(total).style.color ="#C2411B"
    }
    else{
        document.getElementById(total).innerHTML="NA";
    }
   total++


   document.getElementById(total).innerHTML=data[j].reimbResolverID;
   total++

   
   if(data[j].reimbTypeID ===1){
    document.getElementById(total).innerHTML="Lodging";
    }
    else if(data[j].reimbTypeID ===2){
    document.getElementById(total).innerHTML="Travel";
    }
    else if(data[j].reimbTypeID ===3){
    document.getElementById(total).innerHTML="Food";
    }
    else
    {
    document.getElementById(total).innerHTML="Other";
    }

    total++;
}


}



document.getElementById("button").addEventListener("click", refreshPage);

document.getElementById("show").addEventListener("click", showForm)

document.getElementById("sub").addEventListener("click",addReimb )

document.getElementById("logout").addEventListener("click", logOut )


function showForm(){

    document.getElementById("form").style.display = "block";

}

function logOut() {

    window.location.href = "./login.html";

}

function refreshPage(){
    window.location.reload();
} 

let res

// this function take the image provided and chage it to the dataurl/ Base64

document.querySelector("#customFile").addEventListener("change", function(){
    console.log(this.files)
    const reader = new FileReader();

    reader.addEventListener("load", ()=>{
        console.log(reader.result);
        res = reader.result
   })

    

    
    reader.readAsDataURL(this.files[0])
    
    console.log(reader.result);

});


// this function taks in the input data from the form and add's the Reambursment to the data base 

async function addReimb(e){
    e.preventDefault();
     let reimbAmount = document.getElementById("amount").value
     let reimbDescription = document.getElementById("description").value
     let reimbTypeID
     let  ele = document.getElementsByName('gridRadios')
     for(let i = 0; i< ele.length; i++){
            if(ele[i].checked)
            reimbTypeID = ele[i].value;
     }   

     let reimbAuthorID = user.user_ID
     let reimbStatusID =1;
     let reimbResolverID =2;
    let image = res
    const reimbursement = {

        reimbAmount,
        reimbAuthorID,
        reimbDescription,
        reimbStatusID,
        reimbTypeID,
        reimbResolverID,
        image
    
    }

    console.log(reimbursement)

    try{

        res = await fetch("http://localhost:8080/project1/add", {
           
           
           method: "POST",

           
           body: JSON.stringify(reimbursement),
          headers:{
               "Content-Type" : "application/json"
           }
       })

        
        console.log(responce);
          
       
   }
    catch(e){
       console.log(e)
   }
   refreshPage();
}

// disabled the submit button if no amout provided 

let manage =(txt) => {
    let bt = document.getElementById("sub");
    if(txt.value !='' ){
        bt.disabled = false;
    }
    else{
        bt.disabled = true;
    }
}
 

