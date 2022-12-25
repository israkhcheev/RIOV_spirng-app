import { useMemo } from 'react';
import { useState } from 'react'
import { createData } from '../../actions/actions';
import Input from '../../components/input/input'
import './form.css'

export default function CreateElementForm({ close }) {
    const [title, setTitle] = useState('');
    const [price, setPrice] = useState('');

    const memoDisabled = useMemo(() => {
        return (!title || !price);
    }, [title, price])

    const submit = (e) => {
        e.preventDefault();
        createData('element', {
            title: title,
            price: price
        })
    }

    return (
        <form className="container_form" onSubmit={submit}>
            <div className="button_form">
                <button onClick={close}>Закрыть</button>
                <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Отправить</button>
            </div>
            <Input label='Название' change={(e) => setTitle(e.value)} />
            <Input label='Стоимость' change={(e) => setPrice(e.value)} />
        </form>
    )
}