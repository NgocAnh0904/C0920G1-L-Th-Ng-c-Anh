import {Component, OnInit, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {EmployeeService} from '../../../services/employee.service';


@Component({
  selector: 'app-employee-delete-dialog',
  templateUrl: './employee-delete-dialog.component.html',
  styleUrls: ['./employee-delete-dialog.component.scss']
})
export class EmployeeDeleteDialogComponent implements OnInit {
  // @ts-ignore
  public employeeOfFullName;
  // @ts-ignore
  public employeeOfId;

  constructor(
    public dialogRef: MatDialogRef<EmployeeDeleteDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public employeeService: EmployeeService
  ) {
  }


  ngOnInit(): void {
    console.log(this.data.data1);
    this.employeeOfFullName = this.data.data1.fullName;
    this.employeeOfId = this.data.data1.id;
  }

  deleteEmployee() {
    // @ts-ignore
    this.employeeService.deleteEmployee(this.employeeOfId).subscribe(data => {
      this.dialogRef.close();
    });
  }
}
