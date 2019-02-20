<table border="1">
<thead>
<tr>
 <th>Id</th>
 <th>Name</th>
 <th>Rollno</th>
 <th>Dept</th>
 <th>Class</th>
 <th>Age</th>
</tr> 
</thead>
@foreach ($studentsdetails as $student)
<tr>
<td>{{$student->id}}</td>
<td>{{$student->name}}</td>
<td>{{$student->rno}}</td>
<td>{{$student->dept}}</td>
<td>{{$student->class}}</td>
<td>{{$student->age}}</td>
<td><a href="{{route('student.edit',$student->id)}}" >edit</a></td>
<td><form action="{{ route('student.destroy',$student->id)}}" method="post">
@csrf
@method('Delete')
<button type="submit">Delete</button>
</form>
</td>
</tr>
@endforeach
</table>