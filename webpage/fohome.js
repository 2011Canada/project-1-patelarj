
    // get the data form the session storage 
    user = JSON.parse(sessionStorage.getItem("json"))
    let  claim = JSON.parse(sessionStorage.getItem("claims"));
    let selected ;
    let newdata=[];
    if(user === null){

        window.location.href = "./login.html";
     }
     

     document.getElementById("name").innerHTML="Name :- "+ user.firstName+" "+user.lastName;

     
     
     
     // hide the form form the user at first 
     // hider riemb details at first form the user 
     document.getElementById("form").style.display = "none";
     document.getElementById("details").style.display="none";



let data
let length;
 async function getReimbursement() {
    try {
        //just wait for the priomise to resolve
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
       

       



     
         
        console.log(data)
       return data;
    }catch(e){
    
        console.log("ops somthoing went wrong")
    }
}
getReimbursement();





function fileterTable(){
    let newdata=[];
    ele = document.getElementsByName("inlineRadioOptions")
    let selected ;
    
    for(let i = 0; i< ele.length; i++){
        if(ele[i].checked)
        selected = ele[i].value;
    }
    console.log(selected)
    for(let j = 0; j<claim.length; j++){
        
        
        
        if(claim[j].reimbStatusID == selected){
           console.log("you are in the if ")
           newdata.push(claim[j])
        }


    }
    
        console.log(newdata)
    
    createTable(newdata)   

}




 
    function createTable(data){
        let total =0 ;
        for(let j = 0; j<data.length; j++){
            let creatTr = document.createElement("tr");
            creatTr.className = data[j].reimb_ID;
            
            creatTr.setAttribute("data-toggle", "modal")
            creatTr.setAttribute("data-target", "#staticBackdrop")
            creatTr.addEventListener("click" , showme )



            let creatTh = document.createElement("th");
            creatTh.scope = "row";
            creatTh.innerHTML= data[j].reimb_ID;
          
            ele = document.getElementsByName("inlineRadioOptions")

         
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



//--------------------------- Reimbursements details of individual claims--------------

    function showme(){

        

        document.getElementById("details").style.display="block";
        console.log(this.className)
        let list = document.getElementsByClassName(this.className)[0];
        document.getElementById("reimbID").innerHTML=this.className;

        let amount = list.getElementsByTagName("td")[0].innerHTML;
        document.getElementById("amo").innerHTML ="Amount --> " + amount;
        console.log(amount)


        let submitedDate = list.getElementsByTagName("td")[1].innerHTML;
        document.getElementById("submited").innerHTML="Submited On --> "+submitedDate;

        let description = list.getElementsByTagName("td")[3].innerHTML;
        document.getElementById("descri").innerHTML ="Description --> "+ description;

       // let resolvedOn = list.getElementsByTagName("td")[3].innerHTML;
        //document.getElementById("description").innerHTML ="Description --> "+ resolvedOn;


        let status = list.getElementsByTagName("td")[4].innerHTML;
        document.getElementById("status").innerHTML ="Status --> "+ status;

        let submitedby = list.getElementsByTagName("td")[5].innerHTML;
        document.getElementById("submitedby").innerHTML ="Submited By --> "+submitedby;

        let type = list.getElementsByTagName("td")[6].innerHTML;
        document.getElementById("reimtype").innerHTML ="Type --> "+ type;

        let approve = document.getElementById("approve");
        approve.disabled = true;
        let denied = document.getElementById("denied");
        denied.disabled = true;
       if( status === "Panding"){

        approve.disabled = false;
        denied.disabled = false;

        }
        document.getElementById("approve").addEventListener("click", approveClicked);
        document.getElementById("denied").addEventListener("click", deniedCliked);

        for (let j =0; j<= data.length; j++){

            if(data[j].reimb_ID == this.className){
                let img = document.getElementById("img");
                img.src = data[j].image;
            }

        }
        
}

//------------------ this will add the data in to the table ----------------------
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


   document.getElementById(total).innerHTML=data[j].reimbAuthorID;
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

//------------------------ All the click events ----------------------------------

document.getElementById("button").addEventListener("click", filterTable);

document.getElementById("show").addEventListener("click", showForm)

document.getElementById("sub").addEventListener("click",addUsers )

document.getElementById("logout").addEventListener("click", logOut )

//document.getElementById("filter").addEventListener("click",fileterTable)

//-------------------------------------Submit the status --------------------------


function approveClicked(){
    console.log("approved cliked");

    let reimb_ID = document.getElementById("reimbID").innerHTML;
    let reimbStatusID =2
    let status={

        reimb_ID,
      reimbStatusID 

    }

    changeStatus(status);


refreshPage()

}


function deniedCliked(){
    console.log("denied cliked");
    let reimb_ID = document.getElementById("reimbID").innerHTML;
    let reimbStatusID =3

    let status={

        reimb_ID,
      reimbStatusID

    }
    changeStatus(status);

    refreshPage()
}

//-------------------------------------Show the Form to create new EMP--------------------------------

function showForm(){

    document.getElementById("form").style.display = "block";

}

//------------------------------------Function to log out-------------------------------------------
function logOut() {

    window.location.href = "./login.html";

}



async function filterTable(){
    
    

    let rmovebody = document.getElementById("tbody")
    while(rmovebody.firstChild){
        rmovebody.removeChild(rmovebody.firstChild)
    }

    let newdata=[];
    ele = document.getElementsByName("inlineRadioOptions")
    let selected ;
    
    for(let i = 0; i< ele.length; i++){
        if(ele[i].checked)
        selected = ele[i].value;
    }
    console.log(selected)
    for(let j = 0; j<data.length; j++){
        
        
        
        if(data[j].reimbStatusID == selected){
           console.log("you are in the if ")
           newdata.push(data[j])
        }
        else if( selected == 0 ){

            newdata.push(data[j])
        }


    }
    
        console.log(newdata)
    
    createTable(newdata)   






    //createTable(data);
     //window.location.reload();
     
}


// this function taks in the input data from the form and add's the Reambursment 

async function addUsers(e){
    e.preventDefault();
     let firstName = document.getElementById("firstname").value
     let lastName = document.getElementById("lastname").value
     let email = document.getElementById("email").value
     let userName = document.getElementById("username").value
     let userPassword = document.getElementById("password").value
     
     
    const users = {

        firstName,
        lastName,
        email,
        userName,
        userPassword,
    
    
    }



    console.log(users)
    if(firstName !== '' && lastName !== '' && email !=='' && userName !== '' && userPassword !== ''){

    try{

        res = await fetch("http://localhost:8080/project1/adduser", {
           
           
           method: "POST",

           
           body: JSON.stringify(users),
          headers:{
               "Content-Type" : "application/json"
           }
       })

        let responce = await res.json()
         
        alert(responce)
         console.log(responce)
          
         refreshPage();
   }
    catch(e){
       console.log(e)
   }

    }

    else{
   
        alert("Please enter valid input")
        refreshPage();
    }

   
}

async function changeStatus(status){

    
    console.log(status)

    try{

        res = await fetch("http://localhost:8080/project1/status", {
           
           
           method: "POST",

           
           body: JSON.stringify(status),
          headers:{
               "Content-Type" : "application/json"
           }
       })

         responce = await res.json();
         
         //refreshPage();
        console.log(responce);
          
       
   }
    catch(e){
       console.log(e)
   }
  
   refreshPage();
   


}

function refreshPage(){
    location.reload();
}

