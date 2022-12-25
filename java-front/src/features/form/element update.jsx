import { useMemo } from 'react';
import { useState } from 'react'
import { createData, updateData } from '../../actions/actions';
import Input from '../../components/input/input'
import './form.css'

export default function UpdateElementForm({ idf, close }) {
    const [id,] = useState(idf);
    const [title, setTitle] = useState('');
    const [price, setPrice] = useState('');

    const memoDisabled = useMemo(() => {
        return (!id);
    }, [id, title, price])

    const submit = (e) => {
        e.preventDefault();
        updateData('element', {
            id: id,
            title: title,
            price: price
        }, id)
    }

    return (
        <form className="container_form" onSubmit={submit}>
            <div className="button_form">
                <button type="button" onClick={close}>Закрыть</button>
                <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Отправить</button>
            </div>
            <Input disabled={true} label='id' value={id} />
            <Input label='Название' change={(e) => setTitle(e.value)} />
            <Input label='Стоимость' change={(e) => setPrice(e.value)} />
        </form>
    )
}