package org.example.model.school;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "upper_dept_id")
    private Long upperDeptId;

    @Column(name = "dept_name")
    private String deptName;

    public Department() {
    }

    public Department(Long deptId, Long upperDeptId, String deptName) {
        this.deptId = deptId;
        this.upperDeptId = upperDeptId;
        this.deptName = deptName;
    }
}
