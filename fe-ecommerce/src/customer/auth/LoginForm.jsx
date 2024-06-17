import { Button, Grid, TextField } from '@mui/material'
import React from 'react'
import { useNavigate } from 'react-router-dom'

const LoginForm = () => {
    const navigate = useNavigate()
    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);

        const data = {
            firstName: formData.get('firstName'),
            lastName: formData.get('lastName'),
            email: formData.get('email'),
            password: formData.get('password')
        }
        console.log(data)

    }
    return (
        <div>
            <h1 className='text-center text-2xl font-bold mb-4'>Login Form</h1>
            <form onSubmit={handleSubmit}>
                <Grid container spacing={3}>
                    <Grid item xs={12}>
                        <TextField
                            required
                            id="email"
                            name="email"
                            label="Email"
                            fullWidth
                            autoComplete="email"
                        />
                    </Grid>

                    <Grid item xs={12}>
                        <TextField
                            required
                            id="password"
                            name="password"
                            label="Password"
                            fullWidth
                            autoComplete="password"
                        />
                    </Grid>

                    <Grid item xs={12}>
                        <Button
                            className='bg-[#9155FE] w-full'
                            type='submit'
                            variant='contained'
                            size='large'
                            sx={{ padding: '.8rem 0', bgcolor: '#9155FE' }}
                        >
                            Login
                        </Button>
                    </Grid>
                </Grid>
            </form>
            <div className='flex justify-center flex-col items-center'>
                <div className='py-3 flex items-center'>
                    <p>Don't Have An Account?</p>
                    <Button onClick={() => navigate('/register')} className='mt-2 ml-5' size='small'>Register</Button>
                </div>
            </div>
        </div>
    )
}

export default LoginForm