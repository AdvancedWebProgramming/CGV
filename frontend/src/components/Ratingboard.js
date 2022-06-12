import {useState} from 'react';
import { Form, Button, Container, ButtonGroup } from 'react-bootstrap'
import axios from 'axios';
import {useNavigate} from "react-router-dom";

const Ratingboard = () => {
    const navigate = useNavigate();
    const [checked, setChecked] = useState(false);
    const [colorButtonValue, setColorButtonValue] = useState('1');
    const colors = [
        {name : '좋았어요', value: '1'},
        {name : '별로였어요', value : '2'}
    ]

    const likes = [
            {name : 'like', value:'1'},
            {name : 'soso', value:'0'}
    ];


    const handleChangeButtonColor =(e)=> {

    }

    const[data, setData] = useState({
        isliked:'',
        content:'',
        movie:'',//현재 상세페이지의 영화 id
    })

    const changeData =(e)=>{
        setData({
            ...data,
            [e.target.name]:e.target.value
        })

        console.log("a")
    }

    const submit =()=>{
        axios.post("/ratingboard", {
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

              <ButtonGroup aria-label = "LikeMovie" className = 'mb-3'>

              </ButtonGroup>

              <Form.Group className="mb-3" controlId="TextareaForReview">
                <Form.Control as="textarea" rows={5} name = "content" onChange={changeData} value={data.content} placeholder="리뷰 내용을 입력하세요"/>
              </Form.Group>

              <Button variant="primary" type="submit">
                Submit
              </Button>
            </Form>
            </Container>
        </div>
    );
};

export default Ratingboard;