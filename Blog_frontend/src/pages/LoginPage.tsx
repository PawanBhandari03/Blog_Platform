import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { apiService } from '../services/apiService';
import { useAuth } from '../components/AuthContext';

const LoginPage = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useNavigate();
  const { login } = useAuth();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError('');
    setIsLoading(true);

    try {
      // Ensure values are strings (extracting from object if necessary)
      const emailStr = typeof email === 'object' && email !== null ? (email as any).value || '' : String(email);
      const passwordStr = typeof password === 'object' && password !== null ? (password as any).value || '' : String(password);

      await login(emailStr, passwordStr);
      navigate('/');
    } catch (err: any) {
      setError(err.message || 'Failed to login. Please try again.');
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="min-h-screen flex items-center justify-center relative overflow-hidden" style={{ background: '#f0f4ff' }}>
      {/* Decorative background orbs */}
      <div className="bg-orb bg-orb-purple" style={{ width: '400px', height: '400px', top: '-100px', right: '-100px', position: 'absolute' }}></div>
      <div className="bg-orb bg-orb-blue" style={{ width: '300px', height: '300px', bottom: '-80px', left: '-80px', position: 'absolute' }}></div>

      <div className="max-w-md w-full space-y-8 animate-fade-in-up px-4">
        <div>
          <h2 className="mt-6 text-center text-3xl font-extrabold accent-text">
            Sign in to your account
          </h2>
          <p className="mt-2 text-center text-sm text-theme-muted">
            Welcome back to the Blog Platform
          </p>
        </div>
        <form className="mt-8 space-y-6 theme-card p-8" onSubmit={handleSubmit}>
          <div className="rounded-md space-y-4">
            <div>
              <label htmlFor="email" className="block text-sm font-medium text-theme-secondary mb-1">
                Email address
              </label>
              <input
                id="email"
                name="email"
                type="email"
                autoComplete="email"
                required
                className="appearance-none rounded-xl block w-full px-4 py-3 theme-input sm:text-sm"
                placeholder="you@example.com"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                disabled={isLoading}
              />
            </div>
            <div>
              <label htmlFor="password" className="block text-sm font-medium text-theme-secondary mb-1">
                Password
              </label>
              <input
                id="password"
                name="password"
                type="password"
                autoComplete="current-password"
                required
                className="appearance-none rounded-xl block w-full px-4 py-3 theme-input sm:text-sm"
                placeholder="••••••••"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                disabled={isLoading}
              />
            </div>
          </div>

          {error && (
            <div className="rounded-xl p-4" style={{ background: '#fef2f2', border: '1px solid #fecaca' }}>
              <div className="flex">
                <div className="ml-3">
                  <h3 className="text-sm font-medium text-red-600">{error}</h3>
                </div>
              </div>
            </div>
          )}

          <div>
            <button
              type="submit"
              disabled={isLoading}
              className="group relative w-full flex justify-center py-3 px-4 border border-transparent text-sm font-semibold rounded-xl text-white btn-accent focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 disabled:opacity-50 disabled:cursor-not-allowed transition-all duration-300"
            >
              {isLoading ? 'Signing in...' : 'Sign in'}
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default LoginPage;