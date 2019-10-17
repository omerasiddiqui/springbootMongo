    
      $(document).ready(function() {
        
        $("#fetchBtn").on("click", function() {
            $("#addNewEmployee").hide();
            $("#deleteEmployee").hide();
            var fetchAll = $.getJSON( "http://localhost:8080/employees/all", function( data ) {
                  console.log("GET'ing employees: ");
                  console.log(data);
             	  $("#employees").empty();

                  
                  data.forEach(function(emp) {
                      $("#employees").append(`<li class="employee-list-item" id="${emp.id}"><a style="color: white;" href="/employees/${emp.id}">${emp.name} - ${emp.jobTitle}</a></li>`)
                  });
                  
                    $("#content").show().css("border", "1px solid white");
            
            });
        });
        
        
        
        
        $("#addUserBtn").on("click", function() {
            $("#deleteEmployee").hide();
            $("#content").hide();
            $("#addNewEmployee").toggle();
        
        })
        
            $("#deleteUserBtn").on("click", function() {
            
            $("#content").hide();
            $("#addNewEmployee").hide();
            $("#deleteEmployee").toggle();
            
            var fetchAll = $.getJSON( "http://localhost:8080/employees/all", function( data ) {
                console.log("GET'ing employees for DELETE: ");
                console.log(data);
           	  $("#deleteEmployeeList").empty();

                
                data.forEach(function(emp) {
                    $("#deleteEmployeeList").append(`<li class="employee-list-item animated" id="${emp.id}"><i class="fas fa-user-times deleteIcon"></i><a class="deleteAnchor" style="color: white;" href="/employees/${emp.id}"> ${emp.name} - ${emp.jobTitle}</a></li>`)
                });
                          
          });
        
        })
        
        ////////////
        
        // POST
        
        $("#addSubmit").on("click", function(e) {
        	
        	var newEmployee = {
        			name: $("#name").val(),
        			jobTitle: $("#jobTitle").val(),
        			region: $("#region").val(),
        			email:$ ("#email").val() 
        	}
        	
        	e.preventDefault();
        	$.ajax({
        		url: "/employees",
        		type: "POST",
        		data: JSON.stringify(newEmployee),
        		contentType: "application/json",
        		success: function(data) {
        			console.log("POST'ed: " + JSON.stringify(newEmployee))
        		},
        		error: function(xhr, text, err) {
        		  	console.log('error: ',err);
       	         	console.log('text: ', text);
       	          	console.log('xhr: ',xhr);
        		}	
        	})
        	
        	$("#name").val(""),
        	$("#jobTitle").val(""),
        	$("#region").val(""),
        	$("#email").val("")
        	
        })
        
        // DELETE
        
  $("#deleteEmployee").on("click", ".deleteIcon", function(e) {
	  console.log(this);
	  var id = $(this).parent()[0].attributes[1].nodeValue;
	  var elementToDelete = $(this).parent()[0];
	  console.log(elementToDelete)
	  
       	var deletedEmployee = {
   			id: id
       	};
       	
       	
       	
       	$.ajax({
       		url: `/employees/${id}`,
       		type: "DELETE",
       		data: JSON.stringify(deletedEmployee),
       		contentType: "application/json",
       		success: function(data) {
    			console.log("DELETE'ed: " + JSON.stringify(deletedEmployee))
    			elementToDelete.classList.add('slideOutLeft')
       		},
       		error: function(xhr, text, err) {
       		  	console.log('error: ',err);
      	         	console.log('text: ', text);
      	          	console.log('xhr: ',xhr);
       		}	
       	}) 
       	       	
       })
       
   });