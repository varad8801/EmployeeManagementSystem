// addEmployee.js
$(document).ready(function() {
    $('#addEmployeeForm').on('submit', function(event) {
        event.preventDefault();

        const empName = $('#empName').val();
        const empDesignation = $('#empDesignation').val();
        const empDepartment = $('#empDepartment').val();
        const empEmailId = $('#empEmailId').val();
        const phNo = $('#phNo').val();
        const empDOJ = $('#empDOJ').val();
        const empDOB = $('#empDOB').val();
        const empAddress = $('#empAddress').val();
        const emergencyContact = $('#emergencyContact').val();
        const managerId = $('#managerId').val();

        $.ajax({
            url: '/employee/add',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                empName,
                empDesignation,
                empDepartment,
                empEmailId,
                phNo,
                empDetails: {
                    empDOJ,
                    empDOB,
                    empAddress,
                    emergencyContact
                },
                managerId
            }),
            success: function(response) {
                $('#responseMessage').html('<p>Employee added successfully!</p>');
                $('#addEmployeeForm')[0].reset(); // Reset the form fields
            },
            error: function(xhr, status, error) {
                $('#responseMessage').html('<p>Error adding employee: ' + xhr.responseText + '</p>');
            }
        });
    });
});
