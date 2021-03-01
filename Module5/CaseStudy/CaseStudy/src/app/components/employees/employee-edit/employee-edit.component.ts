import {Component, OnInit} from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {EmployeeService} from '../../../services/employee.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.scss']
})
export class EmployeeEditComponent implements OnInit {
  // @ts-ignore
  public formEditEmployee: FormGroup;
  public maxDate = new Date();
  public minDate = new Date(1900, 0, 1);
  // @ts-ignore
  public employeeOfId;

  constructor(
    public formBuilder: FormBuilder,
    public employeeService: EmployeeService,
    public router: Router,
    public activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit(): void {
    this.formEditEmployee = this.formBuilder.group({
        fullName: ['', [Validators.required]],
        position: ['', [Validators.required]],
        academical: ['', [Validators.required]],
        department: ['', [Validators.required]],
        dateOfBirth: ['', [Validators.required]],
        iNumber: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
        salary: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
        email: ['', [Validators.required, Validators.email]],
        phoneNumber: ['', [Validators.required, Validators.pattern('^(090|091|([\(]84[\)][\+]90)|([\(]84[\)][\+]91))[0-9]{7}$')]],
        address: ['', [Validators.required]],
      }
    );
    this.activatedRoute.params.subscribe(data => {
      this.employeeOfId = data.id;
      this.employeeService.getEmployeeById(this.employeeOfId).subscribe(data =>{
        this.formEditEmployee.patchValue(data);
      });
    });
  }

  editEmployee() {
    this.employeeService.editEmployee(this.formEditEmployee.value, this.employeeOfId).subscribe(data =>{
      this.router.navigateByUrl('employee-list');
    })
  }

}

