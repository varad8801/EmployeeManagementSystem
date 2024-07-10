$(document).ready(function() {
    // Fetch total number of employees
    $.ajax({
        url: '/dashboard/totalEmployees',
        method: 'GET',
        success: function(data) {
            $('#totalEmployees').text(data);
        },
        error: function(xhr, status, error) {
            $('#totalEmployees').text('Error fetching data');
            console.error('Error fetching total employees:', error);
        }
    });
    $.ajax({
        url: '/employee/allEmployees',
        method: 'GET',
        success: function(data) {
            // Process the data to get counts by designation
            const designationCounts = {};
            data.forEach(employee => {
                if (designationCounts[employee.empDesignation]) {
                    designationCounts[employee.empDesignation]++;
                } else {
                    designationCounts[employee.empDesignation] = 1;
                }
            });

            const designations = Object.keys(designationCounts);
            const counts = Object.values(designationCounts);

            const ctx = document.getElementById('designationChart').getContext('2d');
            new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: designations,
                    datasets: [{
                        data: counts,
                        backgroundColor: ['#007bff', '#28a745', '#dc3545', '#ffc107', '#17a2b8', '#6c757d', '#fd7e14', '#20c997', '#e83e8c', '#6610f2']
                    }]
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'left',
                        },
                        tooltip: {
                            callbacks: {
                                label: function(context) {
                                    const label = context.label || '';
                                    const value = context.raw || 0;
                                    return `${label}: ${value}`;
                                }
                            }    
                        }
                    }
                }
            });
        },
        error: function(xhr, status, error) {
            console.error('Error fetching designation data:', error);
        }
    });
    $.ajax({
        url: '/dashboard/recentActivity',
        method: 'GET',
        success: function(data) {
            $('#recentActivities').empty(); // Clear the existing content
            if (data.length === 0) {
                $('#recentActivities').append('<li>No recent activities found.</li>');
            } else {
                $.each(data, function(index, logWrapper) {
                    $('#recentActivities').append('<li>' + logWrapper.formattedTimestamp + ': ' + logWrapper.details + '</li>');
                });
            }
        },
        error: function() {
            $('#recentActivities').empty();
            $('#recentActivities').append('<li>Error loading recent activities.</li>');
        }
    })
});

  