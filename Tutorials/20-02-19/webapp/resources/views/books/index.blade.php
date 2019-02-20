<table border="1">
<thead>
<tr>
 <th>Id</th>
 <th>Title</th>
 <th>Body</th>
 <th>Edit</th>
 <th>Delete</th>
</tr> 
</thead>
@foreach ($booksdetails as $book)
<tr>
<td>{{$book->id}}</td>
<td>{{$book->title}}</td>
<td>{{$book->body}}</td>
<td><a href="{{route('book.edit',$book->id)}}" >edit</a></td>
<td><form action="{{ route('book.destroy',$book->id)}}" method="post">
@csrf
@method('Delete')
<button type="submit">Delete</button>
</form>
</td>
</tr>
@endforeach
</table>