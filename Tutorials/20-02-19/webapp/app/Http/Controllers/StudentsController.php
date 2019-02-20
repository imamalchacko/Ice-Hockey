<?php

namespace App\Http\Controllers;

use App\Students;
use Illuminate\Http\Request;

class StudentsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $students=Students::all();
        $studentsdetails  =Students::all();
        return view('students.index',compact('studentsdetails'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view('students.student');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $student=new Students([
            'name'=>$request->get('name'),
            'rno'=>$request->get('rno'),
            'dept'=>$request->get('dept'),
            'class'=>$request->get('class'),
            'age'=>$request->get('age')
        ]);
        $student->save();
        return redirect('/student');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Students  $students
     * @return \Illuminate\Http\Response
     */
    public function show(Students $students)
    {
        return view('students.student');
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Students  $students
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        $students=Students::find($id);
       return view('students.edit',compact('students'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Students  $students
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $student=Students::find($id);
        $student->name = $request->get('name');
        $student->rno = $request->get('rno');
        $student->dept = $request->get('dept');
        $student->class = $request->get('class');
        $student->age = $request->get('age');
        $student->save();
        return redirect('/student');
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Students  $students
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $student=Students::find($id);
        $student->delete();
        return redirect('/student')->with('sucess','student has deleted sucessfully');
    }
}
