	
var userInfo = JSON.parse(sessionStorage.getItem("userInfo"));
		console.log(userInfo.userID);


async function checkHistory(){
    var typeHere;
    try{
        var historyTable= "<table class=\"table\"><thead  style=\"text-align:center;\"><tr>"
        + "<th scope=\"col\">ID</th>"
        + "<th scope=\"col\">AMOUNT</th><th scope=\"col\">TYPE</th>"
        + "<th scope=\"col\">DESCRIPTION</th>"
        + "<th scope=\"col\">SUBMITTED DATE</th>"
        + "<th scope=\"col\">APPROVED DATE</th></tr></thead><tbody>"
   fetch("http://localhost:8080/Project-1/viewHistory/"+userInfo.userID)
   .then(res=>{return res.json()})
   .then(data=>{
       console.log(data.length);
       if(data.length!=0){
          for(let x=0; x<data.length;x++){
             if(data[x].reimbursementResolved==null){
                 data[x].reimbursementResolved=' ';
             } 
             if(data[x].reimbursementSubmitted!=null){
                data[x].reimbursementSubmitted=data[x].reimbursementSubmitted.substring(0,19)
             }
             if(data[x].reimbursementResolved!=null){
                data[x].reimbursementResolved=data[x].reimbursementResolved.substring(0,19)
             }
             if(data[x].type==1){
                typeHere="LODGING"
             }
             else  if(data[x].type==2){
                typeHere="TRAVEL"
             }
             else  if(data[x].type==3){
                typeHere="FOOD"
             }
             else{
                 typeHere="OTHER"
             }
             historyTable+="<tr><td>" + data[x].reimbursementID + "</td>"
             + "<td> $" + data[x].reimbursementAmmount + "</td><td>" + typeHere +"</td>"
             + "<td>" + data[x].reimbursementDescription + "</td>"
             + "<td>" + data[x].reimbursementSubmitted + "</td><td>" + data[x].reimbursementResolved +"</td>"
             + "<td>" + "</td>"
              +"</td></tr>"
          } 
          historyTable+="</tbody></table>"
          document.getElementById('empBody').innerHTML=historyTable;
       }
       else{
        document.getElementById('empBody').innerHTML="No Data Available";
       }
   })
    }catch(e){
        console.log(e);
    }
}

function newReimbursement(){
   // e.preventDefault();
console.log("I am here");
    let amount = document.getElementById("amount").value;
    let desc = document.getElementById("description").value;
    let author = userInfo.userID; //UserId
    let type;
    if(document.getElementById("travel").checked){
        type=2;
    }
    else if(document.getElementById("lodging").checked){
        type=1;
    }
    else if(document.getElementById("food").checked){
        type=3;
    }
    else{
        type=4;
    }
    const reimb={
    reimbursementAmmount:amount,
    reimbursementDescription:desc,
    reimbursementAuthorId:author,
    type:type
}
console.log(JSON.stringify(reimb))
try{
   
    fetch("http://localhost:8080/Project-1/newReimb",{
   method:"PUT",
   body:JSON.stringify(reimb),
   headers:{
       "Content-Type":"application/json"
   }  
    })
    alert("Reimbursement created")    
    window.location.href='./employee.html'

}catch(e){
    console.log("ERROR");
    console.log(e);
}
 
}
async function logOut(){
    sessionStorage.clear();
}