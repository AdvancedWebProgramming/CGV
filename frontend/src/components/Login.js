import {useState} from 'react';
import { Form, Button, Container } from 'react-bootstrap'
import axios from 'axios';
import {useNavigate} from "react-router-dom";

const Login = () => {
    const navigate = useNavigate();

    const[data, setData] = useState({
        loginid:'',
        password:''
    })

    const changeData =(e)=>{
        setData({
            ...data,
            [e.target.name]:e.target.value
        })

        console.log("a")
    }

    const submit =()=>{
        axios.post("/login", {
            id:data.loginid,
            password:data.password
        }).then((resp)=>{
            if(resp.data==="success"){//서버 respond보고 수정해야함
                alert("로그인 성공")
            }
            else if(resp.data==="wrong ID"){//서버 respond보고 수정해야함
                alert("ID를 잘못 입력하였습니다")
            }
            else if(resp.data==="wrong password"){//서버 respond보고 수정해야함
                alert("password를 잘못 입력하였습니다")
            }
        })
    }

    return (
        <div>
        <Container>
            <Form>
              <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>ID</Form.Label>
                <Form.Control type="text" name = "loginid" onChange={changeData} value={data.loginid} placeholder="Enter ID"/>
              </Form.Group>

              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" name="password" onChange={changeData} value={data.password} placeholder="Enter password" />
              </Form.Group>

              <Button variant="primary" type="submit">
                Submit
              </Button>
            </Form>
            </Container>
        </div>
    );
};

export default Login;