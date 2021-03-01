import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, observable} from 'rxjs';
import {ObjectAssignBuiltinFn} from '@angular/compiler-cli/src/ngtsc/partial_evaluator/src/builtin';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public API = 'http://localhost:3000/employees';

  constructor(
    public http: HttpClient
  ) {
  }

  getAllEmployees(): Observable<any> {
    return this.http.get(this.API);
  }

  // @ts-ignore
  addNewEmployee(employee): Observable<any> {
    return this.http.post(this.API, employee);
  }

  // @ts-ignore
  getEmployeeById(employeeId): Observable<any> {
    return this.http.get(this.API + '/' + employeeId);
  }

  // @ts-ignore
  deleteEmployee(employeeId): Observable<any>{
    return this.http.delete(this.API + '/' + employeeId);
  }

  editEmployee(employee, employeeId): Observable<any>{
    return this.http.put(this.API + '/' + employeeId, employee);
  }
}
