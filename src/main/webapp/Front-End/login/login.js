function redirect(user){
     sessionStorage.setItem("userInfo",JSON.stringify(user));
     var role=user.role;
     if(role==1){
         location.href='../employeePage/employee.html'
     }
     else{
         location.href='../managerPage/manager.html'
     }
 }
 async function loadDoc(e) {
     e.preventDefault();
     let username = document.getElementById("userId").value;
     let password = document.getElementById("password").value;
     const credentials = {
          username,
          password:password
     }
     try{
          let res = await fetch("http://localhost:8080/Project-1/login",{
               method:"POST",
               body: JSON.stringify(credentials),
               headers:{
                    "Content-Type" : "application/json"
               }
          })
          let user = await res.json()
          console.log(user)
          redirect(user);
     }catch(e){
          alert("USER DOES NOT EXIST OR PASSWORD IS NOT CORRECT")
          location.href='login.html'
          console.log(e);
     }
 }
 document.getElementsByTagName("form")[0].addEventListener('submit',loadDoc);