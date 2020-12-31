
    // get the data form the session storage 
    user = JSON.parse(sessionStorage.getItem("json"))
     document.getElementById("name").innerHTML= user.firstName;
     
     
     
     // hide the form form the user at first 
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
        //if you want to wait for a promise to respolve we have to make it so the function can be stopped temporarily
        //this means the function will have to be async


        data = await response.json()
         sessionStorage.setItem("claims", JSON.stringify(data));
         createTable(claim);
         //length = data.length
        // createTable(data);
         
        console.log(data)
       return data;
    }catch(e){
    
        console.log("ops somthoing went wrong")
    }
}
getReimbursement();

let  claim = JSON.parse(sessionStorage.getItem("claims"));
//createTable(claim);
 
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

document.getElementById("button").addEventListener("click", refreshPage);

document.getElementById("show").addEventListener("click", showForm)

//document.getElementById("sub").addEventListener("click",addReimb )

document.getElementById("logout").addEventListener("click", logOut )



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


}

//-------------------------------------Show the Form to create new EMP--------------------------------

function showForm(){

    document.getElementById("form").style.display = "block";

}

//------------------------------------Function to log out-------------------------------------------
function logOut() {

    window.location.href = "./login.html";

}

function refreshPage(){
    window.location.reload();
} 



// this function taks in the input data from the form and add's the Reambursment 

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
    const reimbursement = {

        reimbAmount,
        reimbAuthorID,
        reimbDescription,
        reimbStatusID,
        reimbTypeID,
        reimbResolverID
    
    
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

         responce = await res.json();
         
         //refreshPage();
        console.log(responce);
          
       
   }
    catch(e){
       console.log(e)
   }
   refreshPage();
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

