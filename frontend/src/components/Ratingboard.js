import React, {useState} from 'react';
import { Form, Button, Container, ButtonGroup, ToggleButton } from 'react-bootstrap'
import axios from 'axios';
import {useNavigate} from "react-router-dom";

const Ratingboard = () => {
    const navigate = useNavigate();
    const [checked, setChecked] = useState(false);
    const [colorButtonValue, setColorButtonValue] = useState('1');
    const [isGood, setIsGood] = useState(false);

    const colors = [
        {name : '좋았어요', value: '1'},
        {name : '별로였어요', value : '2'}
    ]

    const goodButton =()=> {
        setIsGood(true);
    }
    const badButton =()=> {
        setIsGood(false);
    }

    const[data, setData] = useState({
        content:'',
        //movie:'',//현재 상세페이지의 영화 id
    })

    const changeData =(e)=>{
        setData({
            ...data,
            [e.target.name]:e.target.value
        })

        console.log(isGood)
    }

    const submit =()=>{
        axios.post("/ratingboard", {
            isGood:data.isGood,
            content:data.content
        }).then((resp)=>{
            if(resp.data==="success"){//서버 respond보고 수정해야함
                alert("등록 성공")
            }

        })
    }

    return (
        <div>
        <Container>
            <Form>

              <ButtonGroup aria-label = "LikeMovie" className = 'mb-3'>
                {colors.map((color, idx) => (
                          <ToggleButton
                            key={idx}
                            id={`color-${idx}`}
                            type="radio"
                            variant={idx % 2 ? 'outline-success' : 'outline-danger'}
                            onClick={idx % 2 ? {badButton} : {goodButton}}
                            name="color"
                            value={color.value}
                            checked={colorButtonValue === color.value}
                            onChange={(e) => setColorButtonValue(e.currentTarget.value)}
                          >
                            {color.name}
                          </ToggleButton>
                        ))}
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