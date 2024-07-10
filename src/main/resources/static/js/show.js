$(document).ready(function() {
    function loadEmployees() {
        $.ajax({
            url: '/employee/allEmployees',
            method: 'GET',
            success: function(data) {
                console.log('Received data:', data); // Log the received data
                const employeeTableBody = $('#employeeTableBody');
                populateTable(employeeTableBody, data);
            },
            error: function(error) {
                console.error('Error fetching employee data:', error);
            }
        });
    }

    function populateTable(tableBody, data) {
        tableBody.empty();

        // Populate table with employee data
        data.forEach(employee => {
            const row = `<tr>
                <td>${employee.empId}</td>
                <td>${employee.empName}</td>
                <td>${employee.empDesignation}</td>
                <td>
                    <button class="btn btn-primary view-btn" data-id="${employee.empId}" data-name="${employee.empName}" data-designation="${employee.empDesignation}">View</button>
                    <button class="btn btn-danger delete-btn" data-id="${employee.empId}">Delete</button>
                </td>
            </tr>`;
            tableBody.append(row);
        });

        // Add event listeners for view buttons
        $('.view-btn').on('click', function() {
            const empId = $(this).data('id');
            const empName = $(this).data('name');
            const empDesignation = $(this).data('designation');

            $('#employeeName').val(empName);
            $('#employeeId').val(empId);
            $('#employeeDesignation').val(empDesignation);

            $('#employeeModal').modal('show');
        });

        // Add event listeners for delete buttons
        $('.delete-btn').on('click', function() {
            const empId = $(this).data('id');
            $.ajax({
                url: '/employee/delete',
                method: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify({ empId: empId }),
                success: function(response) {
                    alert('Employee deleted successfully!');
                    location.reload();
                },
                error: function(error) {
                    console.error('Error deleting employee:', error);
                    alert('Failed to delete employee.');
                }
            });
        });
    }

    // Event listener for search bar
    $('#searchBar').on('input', function() {
        const query = $(this).val().toLowerCase();
        $('#employeeTableBody tr').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(query) > -1);
        });
    });

    // Event listener for update button in the modal
    $('#updateEmployeeBtn').on('click', function() {
        const empId = $('#employeeId').val();
        const empName = $('#employeeName').val();
        const empDesignation = $('#employeeDesignation').val();

        const updatedEmployee = {
            empId: empId,
            empName: empName,
            empDesignation: empDesignation
        };

        $.ajax({
            url: '/employee/update',
            method: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify([updatedEmployee]),
            success: function(response) {
                alert('Employee updated successfully!');
                $('#employeeModal').modal('hide');
                loadEmployees();
            },
            error: function(error) {
                console.error('Error updating employee:', error);
                alert('Failed to update employee.');
            }
        });
    });

    loadEmployees();
});
