import { useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import axios from 'axios';
import { useNavigate } from "react-router-dom";

const SignUp = () =>{

    const navigate = useNavigate();

    const[data, setData] = useState({
        loginid:'',
        password:'',
        confirmPassword:'',
        name:'',
        birthday:''
    })

    const changeData = (e)=>{
        setData({
            ...data,
            [e.target.name]:e.target.value
        })

        console.log("a")
    }

    const submit =()=>{
        axios.post("/signup", {
            id:data.loginid,
            password:data.password,
            confirmPassword:data.confirmPassword,
            name:data.name,
            birthday:data.birthday
        }).then((resp)=>{
            if(data.password != data.confirmPassword) {
                alert("비밀번호와 비밀번호 확인은 같아야합니다.")
            }
            else if(resp.data==="success") {//서버 respond보고 수정해야함
                alert("등록성공")
                setData({
                    loginid:'',
                    password:'',
                    confirmPassword:'',
                    name:'',
                    birthday:''
                })
                navigate("/login");
            }
        })
    }

    return(
        <Container>
        <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Label>ID</Form.Label>
        <Form.Control type="text" name="LoginID" onChange={changeData} value={data.loginid} placeholder="Enter ID" />
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" name="password" onChange={changeData} value={data.password} placeholder="Enter password" />
        <Form.Label>Confirm Password</Form.Label>
        <Form.Control type="password" name="confirm password" onChange={changeData} value={data.confirmPassword} placeholder="Confirm password" />
        <Form.Label>Name</Form.Label>
        <Form.Control type="text" name="name" onChange={changeData} value={data.name} placeholder="Enter Name" />
        <Form.Label>Birthday</Form.Label>
        <Form.Control type="text" maxLength='6' name="birthday" onChange={changeData} value={data.birthday} placeholder="Enter Birthday(6 letters)" />
        <br/>
        <Button type="button" onClick={submit}>등록</Button>
        </Form.Group>
        </Container>
    )
}

export default SignUp;