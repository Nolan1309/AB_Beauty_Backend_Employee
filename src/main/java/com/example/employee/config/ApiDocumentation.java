package com.example.employee.config;

/**
 * Class này cung cấp tài liệu chi tiết về tất cả các API endpoint trong ứng dụng.
 * Giúp developers dễ dàng hiểu và sử dụng các API.
 */
public class ApiDocumentation {

    /**
     * Authentication API
     */
    public static class AuthApi {
        /**
         * POST /api/auth/login
         * Đăng nhập và lấy JWT token
         * Body: { "email": "user@example.com", "password": "password" }
         * Response: { "status": 200, "message": "Login successful", "data": { "accessToken": "...", "refreshToken": "...", "roles": "...", "userName": "...", "email": "..." }, "timestamp": "..." }
         */
        public static final String LOGIN = "/api/auth/login";

        /**
         * POST /api/auth/register
         * Đăng ký tài khoản mới
         * Body: { "email": "user@example.com", "password": "password", "name": "User Name", ... }
         * Response: { "message": "Registration successful", "data": { ... }, "status": 200 }
         */
        public static final String REGISTER = "/api/auth/register";

        /**
         * GET /api/auth/refresh-token?refreshToken={token}
         * Refresh JWT token sử dụng refresh token
         * Param: refreshToken - Refresh token đã nhận được khi đăng nhập
         * Response: { "status": 200, "message": "Token refreshed successfully", "data": { "accessToken": "...", "refreshToken": "...", ... }, "timestamp": "..." }
         */
        public static final String REFRESH_TOKEN = "/api/auth/refresh-token";

        /**
         * POST /api/auth/logout?refreshToken={token}
         * Đăng xuất và vô hiệu hóa refresh token
         * Param: refreshToken - Refresh token cần vô hiệu hóa
         * Response: { "message": "Đăng xuất thành công", "data": { "timestamp": "..." }, "status": 200 }
         */
        public static final String LOGOUT = "/api/auth/logout";
    }

    /**
     * Employee API
     */
    public static class EmployeeApi {
        /**
         * GET /api/employee?page={page}&size={size}
         * Lấy danh sách tất cả nhân viên với phân trang
         * Params: page - Số trang (mặc định 0), size - Kích thước trang (mặc định 50)
         * Response: { "message": "Employees retrieved successfully.", "data": { ... }, "status": 200 }
         */
        public static final String GET_ALL = "/api/employee";

        /**
         * GET /api/employee/{employeeCode}
         * Lấy thông tin chi tiết của một nhân viên theo mã
         * Param: employeeCode - Mã nhân viên
         * Header: Authorization - Bearer token
         * Response: { "message": "Employee retrieved successfully.", "data": { ... }, "status": 200 }
         */
        public static final String GET_BY_CODE = "/api/employee/{employeeCode}";

        /**
         * GET /api/employee/same-company?page={page}&size={size}
         * Lấy danh sách đồng nghiệp (cùng công ty) của nhân viên đang đăng nhập
         * Params: page - Số trang (mặc định 0), size - Kích thước trang (mặc định 10)
         * Header: Authorization - Bearer token
         * Response: { "message": "Retrieved colleagues successfully", "data": { ... }, "status": 200 }
         */
        public static final String GET_MY_COLLEAGUES = "/api/employee/same-company";

        /**
         * POST /api/employee
         * Tạo nhân viên mới 
         * Body: { ... } (EmployeeDTO)
         * Response: { "message": "Employee created successfully", "data": { ... }, "status": 200 }
         */
        public static final String CREATE = "/api/employee";

        /**
         * PUT /api/employee/{employeeCode}
         * Cập nhật thông tin nhân viên
         * Param: employeeCode - Mã nhân viên
         * Body: { ... } (EmployeeDTO)
         * Header: Authorization - Bearer token
         * Response: { "message": "Update successful", "data": { ... }, "status": 200 }
         */
        public static final String UPDATE = "/api/employee/{employeeCode}";

        /**
         * DELETE /api/employee/{employeeCode}
         * Xóa nhân viên
         * Param: employeeCode - Mã nhân viên
         * Response: { "message": "Employee deleted successfully", "data": null, "status": 200 }
         */
        public static final String DELETE = "/api/employee/{employeeCode}";
    }

    /**
     * Company API
     */
    public static class CompanyApi {
        /**
         * GET /api/company?page={page}&size={size}
         * Lấy danh sách tất cả công ty với phân trang
         * Params: page - Số trang (mặc định 0), size - Kích thước trang (mặc định 50)
         * Response: { "message": "Companies retrieved successfully.", "data": { ... }, "status": 200 }
         */
        public static final String GET_ALL = "/api/company";

        /**
         * GET /api/company/{companyCode}
         * Lấy thông tin chi tiết của một công ty theo mã
         * Param: companyCode - Mã công ty
         * Response: { "message": "Company retrieved successfully.", "data": { ... }, "status": 200 }
         */
        public static final String GET_BY_CODE = "/api/company/{companyCode}";

        /**
         * POST /api/company
         * Tạo công ty mới
         * Body: { ... } (CompanyDTO)
         * Response: { "message": "Company created successfully", "data": { ... }, "status": 200 }
         */
        public static final String CREATE = "/api/company";

        /**
         * PUT /api/company/{companyCode}
         * Cập nhật thông tin công ty
         * Param: companyCode - Mã công ty
         * Body: { ... } (CompanyDTO)
         * Response: { "message": "Update successful", "data": { ... }, "status": 200 }
         */
        public static final String UPDATE = "/api/company/{companyCode}";

        /**
         * DELETE /api/company/{companyCode}
         * Xóa công ty
         * Param: companyCode - Mã công ty
         * Response: { "message": "Company deleted successfully", "data": null, "status": 200 }
         */
        public static final String DELETE = "/api/company/{companyCode}";
    }

    /**
     * Department API
     */
    public static class DepartmentApi {
        /**
         * GET /api/department?page={page}&size={size}
         * Lấy danh sách tất cả phòng ban với phân trang
         * Params: page - Số trang (mặc định 0), size - Kích thước trang (mặc định 50)
         * Response: { "message": "Departments retrieved successfully.", "data": { ... }, "status": 200 }
         */
        public static final String GET_ALL = "/api/department";

        /**
         * GET /api/department/{departmentCode}
         * Lấy thông tin chi tiết của một phòng ban theo mã
         * Param: departmentCode - Mã phòng ban
         * Response: { "message": "Department retrieved successfully.", "data": { ... }, "status": 200 }
         */
        public static final String GET_BY_CODE = "/api/department/{departmentCode}";

        /**
         * POST /api/department
         * Tạo phòng ban mới
         * Body: { ... } (DepartmentDTO)
         * Response: { "message": "Department created successfully", "data": { ... }, "status": 200 }
         */
        public static final String CREATE = "/api/department";

        /**
         * PUT /api/department/{departmentCode}
         * Cập nhật thông tin phòng ban
         * Param: departmentCode - Mã phòng ban
         * Body: { ... } (DepartmentDTO)
         * Response: { "message": "Update successful", "data": { ... }, "status": 200 }
         */
        public static final String UPDATE = "/api/department/{departmentCode}";

        /**
         * DELETE /api/department/{departmentCode}
         * Xóa phòng ban
         * Param: departmentCode - Mã phòng ban
         * Response: { "message": "Department deleted successfully", "data": null, "status": 200 }
         */
        public static final String DELETE = "/api/department/{departmentCode}";
    }

    /**
     * Salary API
     */
    public static class SalaryApi {
        /**
         * GET /api/salary?page={page}&size={size}
         * Lấy danh sách tất cả bảng lương với phân trang
         * Params: page - Số trang (mặc định 0), size - Kích thước trang (mặc định 50)
         * Response: { "message": "Salaries retrieved successfully.", "data": { ... }, "status": 200 }
         */
        public static final String GET_ALL = "/api/salary";

        /**
         * GET /api/salary/{salaryId}/employee/{employeeCode}
         * Lấy thông tin lương của một nhân viên
         * Params: salaryId - ID bảng lương, employeeCode - Mã nhân viên
         * Response: { "message": "Salary retrieved successfully.", "data": { ... }, "status": 200 }
         */
        public static final String GET_BY_EMPLOYEE = "/api/salary/{salaryId}/employee/{employeeCode}";

        /**
         * GET /api/salary/employee/{employeeCode}/salary/{month}
         * Lấy thông tin lương của một nhân viên theo tháng
         * Params: employeeCode - Mã nhân viên, month - Tháng (định dạng yyyy-MM)
         * Response: { "message": "Salary retrieved successfully.", "data": { ... }, "status": 200 }
         */
        public static final String GET_BY_MONTH = "/api/salary/employee/{employeeCode}/salary/{month}";

        /**
         * POST /api/salary
         * Tạo bảng lương mới
         * Body: { ... } (SalaryDTO)
         * Response: { "message": "Salary created successfully", "data": { ... }, "status": 200 }
         */
        public static final String CREATE = "/api/salary";

        /**
         * PUT /api/salary/{salaryId}
         * Cập nhật thông tin bảng lương
         * Param: salaryId - ID bảng lương
         * Body: { ... } (SalaryDTO)
         * Response: { "message": "Update successful", "data": { ... }, "status": 200 }
         */
        public static final String UPDATE = "/api/salary/{salaryId}";

        /**
         * DELETE /api/salary/{salaryId}
         * Xóa bảng lương
         * Param: salaryId - ID bảng lương
         * Response: { "message": "Salary deleted successfully", "data": null, "status": 200 }
         */
        public static final String DELETE = "/api/salary/{salaryId}";
    }
} 