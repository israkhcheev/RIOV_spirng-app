import { useMemo } from 'react';
import { useState } from 'react'
import { createData } from '../../actions/actions';
import CheckBox from '../../components/input/checkbox';
import Input from '../../components/input/input'
import './form.css'

export default function CreateShopForm({ close }) {
    const [name, setName] = useState('');
    const [type, setType] = useState('');
    const [isOnline, setOnline] = useState(false);

    const memoDisabled = useMemo(() => {
        return (!name || !type);
    }, [name, type, isOnline])

    const submit = (e) => {
        e.preventDefault();
        createData('shop', {
            name: name,
            type: type,
            isOnline: isOnline
        })
    }

    return (
        <form className="container_form" onSubmit={submit}>
            <div className="button_form">
                <button onClick={close}>Закрыть</button>
                <button type="submit" className={memoDisabled ? 'disabled' : ''} disabled={memoDisabled} >Отправить</button>
            </div>
            <Input label='Название' change={(e) => setName(e.value)} />
            <Input label='Тип' change={(e) => setType(e.value)} />
            <CheckBox label='Онлайн магазин' change={(e) => setOnline(e.checked)} />
        </form>
    )
}