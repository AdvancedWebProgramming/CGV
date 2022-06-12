import {useState} from 'react';
import { Form, Button, Container } from 'react-bootstrap'
import axios from 'axios';
import {useNavigate} from "react-router-dom";

const Login = () => {
    const navigate = useNavigate();

    const[data, setData] = useState({
        isliked:'',
        content:'',
        movie:'',
        writer:''
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
            isliked:data.isliked,
            content:data.content
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

              <Button variant="primary" className = "m-1" type="submit">
                               재밌어요
              </Button>

              <Button variant="secondary" className = "m-1" type="submit">
                              별로였어요
              </Button>

              <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>ID</Form.Label>
                <Form.Control type="text" name = "id" onChange={changeData} value={data.id} placeholder="Enter ID"/>
              </Form.Group>

              <Button vaiantr="primary" type="submit">
                Submit
              </Button>
            </Form>
            </Container>
        </div>
    );
};

export default Login;