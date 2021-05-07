var userInfo=JSON.parse(sessionStorage.getItem("userInfo"));
document.getElementById("yourName").innerHTML=" "+userInfo.firstName;
element=document.getElementById("modal")
element.style.display='none';
async function viewAllReimbursements(){
   var typeS,statusValue;
    try{
      
         fetch("http://localhost:8080/Project-1/viewAllTickets")
         .then(response => {return response.json()})
         .then(data =>{
            //ID/AUTHOR/AMOUNT/TYPE/SUBMIT(date)/APPROVE(date)/DESCRIPTION/STATUS
            if(data.length != 0){
                var newTable = "<table class=\"table\"><thead  style=\"text-align:center;\"><tr>"
                + "<th scope=\"col\">ID</th><th scope=\"col\">APPLICANT</th>"
                + "<th scope=\"col\">AMOUNT</th><th scope=\"col\">TYPE</th><th scope=\"col\">DESCRIPTION</th>"
                + "<th scope=\"col\">SUBMITTED DATE</th>"
                + "<th scope=\"col\">APPROVED DATE</th><th scope=\"col\">APPROVAL</th>"
                + "<th scope=\"col\">STATUS</th></tr></thead><tbody>"

                for(let x = 0;x<data.length;x++){
                    if(data[x].reimbursementResolved == null){
                        data[x].reimbursementResolved = '-'
                    }                   
                    if(data[x].reimbursementSubmitted == null){  data[x].reimbursementSubmitted = '-' }
                    else{ data[x].reimbursementSubmitted = data[x].reimbursementSubmitted.substring(0,19)}
                    
                    if(data[x].reimbursementResolverId==0){
                        data[x].reimbursementResolverId='-'
                    }
                   
                    if(data[x].type===1){typeS="LODGING"}
                    else if(data[x].type===2){typeS="TRAVEL"}
                    else if(data[x].type===3){typeS="FOOD"}
                    else{type="OTHER"}
                    console.log(data[x].reimbursementStatusId)
                    if(data[x].reimbursementStatusId===1){statusValue="pending"}
                    else  if(data[x].reimbursementStatusId===2){statusValue="denied"}
                    else {statusValue="approved"}
                    newTable += "<tr><td>" + data[x].reimbursementID + "</td><td>" + data[x].reimbursementAuthorId +"</td>"
                            + "<td>$" + data[x].reimbursementAmmount + "</td><td>" + typeS +"</td>"
                            + "<td>" + data[x].reimbursementDescription + "</td>"
                            + "<td>" + data[x].reimbursementSubmitted + "</td><td>" + data[x].reimbursementResolved +"</td>"
                            + "<td>" + data[x].reimbursementResolverId + "</td><td>" + statusValue +"</td></tr>"
                }
                newTable += "</tbody></table>"
                document.getElementById('fmBody').innerHTML = newTable;
            }else{
                document.getElementById('fmBody').innerHTML = "NO DATA EXIST";
            }
         })
    }catch(e){
         console.log(e);
    }
}

async function OnSelectionChange_All(opt){

    if(opt.value == 0){
        viewAllReimbursements();}
        else if(opt.value==1){
pendingTickets();
        
    }else{
        try{
             fetch("http://localhost:8080/Project-1/reimb/" +opt.value)
             .then(response => {return response.json()})
             .then(data =>{
                 //ID/AUTHOR/AMOUNT/TYPE/SUBMIT(date)/APPROVE(date)/DESCRIPTION/STATUS/RESOLVER
                 if(data.length != 0){
                    var newTable = "<table class=\"table\"><thead  style=\"text-align:center;\"><tr>"
                    + "<th scope=\"col\">ID</th><th scope=\"col\">EMPLOYEE_ID</th>"
                    + "<th scope=\"col\">AMOUNT</th><th scope=\"col\">TYPE</th><th scope=\"col\">DESCRIPTION</th>"
                    + "<th scope=\"col\">SUBMITTED DATE</th>"
                    + "<th scope=\"col\">APPROVED DATE</th><th scope=\"col\">APPROVAL</th>"
                    + "<th scope=\"col\">STATUS</th></tr></thead><tbody>"
    
                    for(let x = 0;x<data.length;x++){
                        if(data[x].reimbursementResolved == null){
                            data[x].reimbursementResolved = '-'
                        }                   
                        if(data[x].reimbursementSubmitted == null){  data[x].reimbursementSubmitted = '-' }
                        else{ data[x].reimbursementSubmitted = data[x].reimbursementSubmitted.substring(0,19)}
                        
                        if(data[x].reimbursementResolverId==0){
                            data[x].reimbursementResolverId='-'
                        }
                       
                        if(data[x].type===1){typeS="LODGING"}
                        else if(data[x].type===2){typeS="TRAVEL"}
                        else if(data[x].type===3){typeS="FOOD"}
                        else{type="OTHER"}
                        if(data[x].reimbursementStatusId===1){statusValue="pending"}
                        else  if(data[x].reimbursementStatusId===2){statusValue="denied"}
                        else {statusValue="approved"}
                        newTable += "<tr><td>" + data[x].reimbursementID + "</td><td>" + data[x].reimbursementAuthorId +"</td>"
                                + "<td>$" + data[x].reimbursementAmmount + "</td><td>" + typeS +"</td>"
                                + "<td>" + data[x].reimbursementDescription + "</td>"
                                + "<td>" + data[x].reimbursementSubmitted + "</td><td>" + data[x].reimbursementResolved +"</td>"
                                + "<td>" + data[x].reimbursementResolverId + "</td><td>" 
                                + statusValue +"</td></tr>"
                    }
                    newTable += "</tbody></table>"
                    document.getElementById('fmBody').innerHTML = newTable;
                }else{
                    document.getElementById('fmBody').innerHTML = "NO DATA EXIST";
                }
             })
        }catch(e){
             console.log(e);
        }
    }
}
function pendingTickets(){
    try{
    fetch("http://localhost:8080/Project-1/reimb/" +1)
             .then(response => {return response.json()})
             .then(data =>{
                 //ID/AUTHOR/AMOUNT/TYPE/SUBMIT(date)/APPROVE(date)/DESCRIPTION/STATUS/RESOLVER
                 if(data.length != 0){
                    var newTable = "<table class=\"table\"><thead  style=\"text-align:center;\"><tr>"
                    + "<th scope=\"col\">ID</th><th scope=\"col\">EMPLOYEE_ID</th>"
                    + "<th scope=\"col\">AMOUNT</th><th scope=\"col\">TYPE</th><th scope=\"col\">DESCRIPTION</th>"
                    + "<th scope=\"col\">SUBMITTED DATE</th>"
                    + "<th scope=\"col\">APPROVED DATE</th><th scope=\"col\">APPROVAL</th>"
                    + "<th scope=\"col\">STATUS</th></tr></thead><tbody>"
    
                    for(let x = 0;x<data.length;x++){
                        if(data[x].reimbursementResolved == null){
                            data[x].reimbursementResolved = '-'
                        }                   
                        if(data[x].reimbursementSubmitted == null){  data[x].reimbursementSubmitted = '-' }
                        else{ data[x].reimbursementSubmitted = data[x].reimbursementSubmitted.substring(0,19)}
                        
                        if(data[x].reimbursementResolverId==0){
                            data[x].reimbursementResolverId='-'
                        }
                       
                        if(data[x].type===1){typeS="LODGING"}
                        else if(data[x].type===2){typeS="TRAVEL"}
                        else if(data[x].type===3){typeS="FOOD"}
                        else{type="OTHER"}
                        newTable += "<tr><td>" + data[x].reimbursementID + "</td><td>" + data[x].reimbursementAuthorId +"</td>"
                                + "<td>$" + data[x].reimbursementAmmount + "</td><td>" + typeS +"</td>"
                                + "<td>" + data[x].reimbursementDescription + "</td>"
                                + "<td>" + data[x].reimbursementSubmitted + "</td><td>" + data[x].reimbursementResolved +"</td>"
                                + "<td>" + data[x].reimbursementResolverId + "</td><td>" 
                                + "PENDING" +"</td>"
                                +"<td id=\"row_"+ x + "\"><button onclick=\"approval("+ data[x].reimbursementID + "," +3+","+x+")\" class=\"btn btn-lg btn-success\" style=\"font-size: 15px; font-weight: bold; margin-right:2vh; height:37px; width:80px; text-align:center; padding:0\">Approve</button>"
                                + "<button onclick=\"approval("+ data[x].reimbursementID + "," +2+","+x+")\" class=\"btn btn-lg btn-danger\" style=\"font-size: 15px; font-weight: bold; height:37px; width:80px; text-align:center; padding:0\">Denied</button></td></span>"
                                +"</tr>"
                    }
                    newTable += "</tbody></table>"
                    document.getElementById('fmBody').innerHTML = newTable;
                }else{
                    document.getElementById('fmBody').innerHTML = "NO DATA EXIST";
                }
             })
        }catch(e){
             console.log(e);
        }
        }

function approval(reimbId, statusId, rowNum){
  try{

    fetch("http://localhost:8080/Project-1/update/"+statusId,{
            method:"PUT",
            body: JSON.stringify({'reimbursementResolverId' : userInfo.userID, 'reimbursementID': reimbId}),
            headers:{
                 "Content-Type" : "application/json"
            }
    })
    if(statusId == 3){ //Approve
        document.getElementById('row_'+rowNum).innerHTML = "APPROVED";
    }else{ //Reject
        document.getElementById('row_'+rowNum).innerHTML = "DENIED";
    }
}catch(e){
    console.log(e);
}
}
async function logOut(){
    sessionStorage.clear();
}