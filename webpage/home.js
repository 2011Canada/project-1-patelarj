
    // user = JSON.parse (localStorage.getItem("json"));
    user = JSON.parse(sessionStorage.getItem("json"))
     document.getElementById("name").innerHTML= user.firstName;
   
    
let data
let length;
 async function getJokeAsync() {
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
        await sessionStorage.setItem("claims", JSON.stringify(data));
        await createTable(claim);
         //length = data.length
        // createTable(data);
         
        console.log(data)
       return data;
    }catch(e){
    
        console.log("ops somthoing went wrong")
    }
}
getJokeAsync();

let  claim = JSON.parse(sessionStorage.getItem("claims"));
//createTable(claim);
 
    function createTable(data){
        let total =0 ;
        for(let j = 0; j<data.length; j++){
            let creatTr = document.createElement("tr");
            let creatTh = document.createElement("th");
            creatTh.scope = "row";
            creatTh.innerHTML= j;
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
   document.getElementById(total).innerHTML=data[j].reimbStatusID;
   total++
   document.getElementById(total).innerHTML=data[j].reimbResolverID;
   total++
   document.getElementById(total).innerHTML=data[j].reimbTypeID; 
total++;
}


}



//document.getElementById("button").addEventListener("click", createTable(claim));
 
