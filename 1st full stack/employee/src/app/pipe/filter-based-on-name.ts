import { Pipe, PipeTransform } from '@angular/core';
import * as _ from 'lodash';
@Pipe({
    name: 'filterBasedOnName'
  })
  export class FilterBasedOnName implements PipeTransform{

    transform(array: any[], query: string): any {
console.log('it come',array);
if(query != null)
{
    query = query.trim();
    return _.filter(array, row=>(row.emp_name!=null && row.emp_name.toLowerCase().startsWith(query.toLowerCase())));
}
if(array!=null)
{
return array;
}
    }
  }